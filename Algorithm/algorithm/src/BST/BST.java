package BST;

import java.util.*;
// Binary Search Tree와 비슷한 객체를 구현해보자.
// Solution의 이너클래스로 Node 클래스와 binaraySearchTree 클래스가 있다.
class BST {
    // 트리를 구성하는 노드 클래스입니다.
    public static class Node {
        private int data;
        // 두개의 자식 노드만 가진다.
        private Node left;
        private Node right;

        /* 생성자 */
        public Node(int data) {
            this.setData(data);
            setLeft(null); // 기본적으로 비어져있다.
            setRight(null);
        }

        public int getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    //이진 탐색 트리의 클래스입니다.
    public static class binarySearchTree {
        public Node root;

        public binarySearchTree(){
            root = null;
        }

        // tree에 value를 추가합니다.
        public void insert(int data) {
            Node newNode = new Node(data); // 왼쪽, 오른쪽 자식 노드가 null 이며 data 의 값이 저장된 새 노드 생성
            if (root == null) {// 루트 노드가 없을때, 즉 트리가 비어있는 상태일 때,
                root = newNode;
                return;
            }
            if(root.data == data) return;   //중복일때 정지

            Node currentNode = root; // 시작을 무조건 root 부터 하기 위해 작성
            Node parentNode = null;

            while (true) {
                parentNode = currentNode; // 부모노드로 root 부터 시작

                if (data < currentNode.getData()) { // 해당 노드보다 작을 경우
                    currentNode = currentNode.getLeft();
                    if (currentNode == null) {
                        parentNode.setLeft(newNode);
                        return;
                    }else if(currentNode.data == newNode.data) return;
                } else { // 해당 노드보다 클 경우
                    currentNode = currentNode.getRight();
                    if (currentNode == null) {
                        parentNode.setRight(newNode);
                        return;
                    }else if(currentNode.data == newNode.data) return;
                }
            }
        }

        // tree의 value값을 탐색합니다.
        public boolean contains(int data) {
            Node currentNode = root;
            while (currentNode != null) {
                // 찾는 value값이 노드의 value와 일치한다면, true를 리턴합니다.
                if (currentNode.data == data) {
                    return true;
                }

                if (currentNode.data > data) {
                    // 찾는 value값이 노드의 value 보다 작다면, 현재 노드를 left로 변경후 다시 반복합니다.
                    currentNode = currentNode.left;
                }else {
                    // 찾는 value값이 노드의 value 보다 크다면, 현재 노드를 right로 변경후 다시 반복합니다.
                    currentNode = currentNode.right;
                }
            }
            return false;
        }

  /*
	트리의 순회에 대해 구현을 합니다.
  지금 만드려고 하는 이 순회 메서드는 단지 순회만 하는 것이 아닌, 함수를 매개변수로 받아 콜백 함수에 값을 적용시킨 것을 순회해야 합니다.
  전위 순회를 통해 어떻게 탐색하는지 이해를 한다면 중위와 후위 순회는 쉽게 다가올 것입니다.
	*/

        // 이진 탐색 트리를 전위 순회하는 메서드를 만듭니다.
        public ArrayList<Integer> preorderTree(Node root, int depth, ArrayList<Integer> list) {    //전위 순회
            if (root != null) {
                list.add(root.getData());
                preorderTree(root.getLeft(), depth + 1, list);
                preorderTree(root.getRight(), depth + 1, list);
            }
            return list;
        }

        public ArrayList<Integer> inorderTree(Node root, int depth, ArrayList<Integer> list) { //중위 순회
            //TODO: 전위 순회를 바탕으로 중위 순회를 구현하세요.
            if (root != null) {
                inorderTree(root.getLeft(), depth + 1, list);
                list.add(root.getData());
                inorderTree(root.getRight(), depth + 1, list);
            }
            return list;
        }

        public ArrayList<Integer> postorderTree(Node root, int depth, ArrayList<Integer> list) {   //후위 순회
            //TODO: 전위 순회를 바탕으로 후위 순회를 구현하세요.
            if (root != null) {
                postorderTree(root.getLeft(), depth + 1, list);
                postorderTree(root.getRight(), depth + 1, list);
                list.add(root.getData());
            }
            return list;
        }
    }

    // 메인함수
    public static void main(String[] args) {
        // static 클래스인 binarySearchTree
        BST.binarySearchTree test = new BST.binarySearchTree();
        test.root = new BST.Node(10); // BST 클래스의 root 값을 설정
        test.insert(7);
        test.insert(8);
        test.insert(6);
        test.insert(12);
        test.insert(11);
        test.insert(13);
        // 노드 값 확인
        System.out.println(test.root.getLeft().getData()); // 7
        System.out.println(test.root.getLeft().getLeft().getData()); // 6
        System.out.println(test.root.getLeft().getRight().getData()); // 8
        System.out.println(test.root.getRight().getLeft().getData()); // 11

        // 순회 모습 탐색해보기
        System.out.println("순회 모습 탐색해보기");
        System.out.println("-".repeat(50));
        System.out.println("전위 순회");
        ArrayList<Integer> search = test.preorderTree(test.root, 0, new ArrayList<Integer>());
        System.out.println(search.toString());

        System.out.println("-".repeat(50));
        System.out.println("중위 순회");
        ArrayList<Integer> search2 = test.inorderTree(test.root, 0, new ArrayList<Integer>());
        System.out.println(search2.toString());

        System.out.println("-".repeat(50));
        System.out.println("후위 순회");
        ArrayList<Integer> search3 = test.postorderTree(test.root, 0, new ArrayList<Integer>());
        System.out.println(search3.toString());

        System.out.println("-".repeat(50));
        System.out.println("값을 다르게 삽입해보기");
        // 만약 다르게 insert 하면 어떻게 될까?
        // 결국 입력 값들의 순서에 따라 모양이 달라진다.
        BST.binarySearchTree test2 = new BST.binarySearchTree();
        test.root = new BST.Node(10);
        test.insert(9);
        test.insert(7);
        test.insert(8);
        test.insert(12);

        System.out.println(test.root.getLeft().getData()); //9
        System.out.println(test.root.getLeft().getLeft().getData()); //7
        System.out.println(test.root.getLeft().getLeft().getRight().getData()); //8

    }
}

