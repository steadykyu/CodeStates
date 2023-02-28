package polymorphism;

class Friend {
    public void friendInfo(){
        System.out.println("나는 당신의 친구입니다.");
    }
}

class BoyFriend extends  Friend{
    boolean haveLove = true;
    @Override
    public void friendInfo() {
        System.out.println("나는 당신의 남자 친구입니다.");
    }
}

class GirlFriend extends  Friend{
    boolean haveLove = true;
    @Override
    public void friendInfo() {
        System.out.println("나는 당신의 여자 친구입니다.");
    }
}

public class FriendTest{

    public static void main(String[] args) {
        Friend friend = new Friend();
        BoyFriend boyFriend = new BoyFriend();
        Friend girlFriend = new GirlFriend();
        //  GirlFriend friend1 = new Friend(); -> 하위클래스 타입으로 상위클래스 객체 참조 -> 불가능

        friend.friendInfo();
        boyFriend.friendInfo();
        girlFriend.friendInfo();

//        girlFriend.haveLove(); // 상위 클래스 타입의 참조변수로는 불가능
    }
}