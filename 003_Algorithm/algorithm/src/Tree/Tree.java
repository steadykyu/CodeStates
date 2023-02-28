package Tree;

import java.util.*;
// tree 구조와 비슷한 객체를 만들어 보자.
class Tree {
    private String value;
    private ArrayList<Tree> children;

    public Tree() {	//전달인자가 없을 경우의 생성자
        this.value = null;
        this.children = null;
    }
    public Tree(String data) {	//전달인자가 존재할 경우의 생성자
        this.value = data;
        this.children = null;
    }

    public void setValue(String data) {
        this.value = data;
    }

    public String getValue() {      //현재 노드의 데이터를 반환
        return value;
    }

    // 트리 구조에서 Node를 추가해주기
    public void addChildNode(Tree node) {
        if(children==null) children = new ArrayList<>();
        children.add(node);
    }
    public void removeChildNode(Tree node) {
        String data = node.getValue();

        if(children != null) {
            for(int i = 0; i < children.size(); i++) {
                if(children.get(i).getValue().equals(data)) {
                    children.remove(i);
                    return;
                }
                if(children.get(i).children != null) children.get(i).removeChildNode(node);
            }
        }
    }

    public ArrayList<Tree> getChildrenNode() {
        return children;
    }

    public boolean contains(String data) {      //재귀를 사용하여 값을 검색합니다.
        if(value.equals(data)) return true;

        if(children != null) {
            for(int i = 0; i < children.size(); i++) {
                // 한번 true 값이 나오면, 트리에 값이 존재한다는 의미이므로 true를 return한다.
                if(children.get(i).contains(data)) return true;
            }
        }
        return false;
    }

    public String toString(){
        return String.format(value + "를 value로 가지는 Tree");
    }

    // 메인함수
    public static void main(String[] args) {
        Tree rootNode = new Tree("0");

        for(int i = 1; i <= 5; i++) {
            rootNode.addChildNode(new Tree(Integer.toString(i)));
        }
        System.out.println(rootNode.getChildrenNode().toString());
        //rootNode 는 {value: 0, children: SequentialSearch(5)}
        System.out.println(rootNode.contains("6")); // false
        System.out.println(rootNode.contains("1")); // true
        System.out.println(rootNode.contains("4")); // true
    }
}

