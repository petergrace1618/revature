package site.petergrace.exercises;

public class SyncMain {
    public static void main(String[] args) {
        new Pages("page1 for user1","page2 for user1");
        new Pages("page1 for user2","page2 for user2");
        new Pages("page1 for user3","page2 for user3");
        new Pages("page1 for user4","page2 for user4");
        new Pages("page1 for user5","page2 for user5");
    }
}
