import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Album newAlbum = new Album("first", "alan");
        newAlbum.addSong("song 1", 5.2);
        newAlbum.addSong("song 2", 5.8);
        newAlbum.addSong("song 3", 5.0);
        newAlbum.addSong("song 4", 3.8);
        newAlbum.addSong("song 5", 4.7);
        newAlbum.addSong("song 6", 2.8);

        LinkedList<Song> myList = new LinkedList();
        newAlbum.addToPlayList("song 1",myList);
        newAlbum.addToPlayList("song 2",myList);
        newAlbum.addToPlayList("song 5",myList);
        newAlbum.addToPlayList("song 6",myList);
        showMenu();
        Scanner in=new Scanner(System.in);
        ListIterator<Song> itr = myList.listIterator();
        boolean forwad=true;
        int ans=0;
        while (true){
            int option=in.nextInt();
            switch (option){
                case 0:
                    play(myList,ans);
                    break;
                case 1:
                    showMenu();
                    break;
                case 2:
                    printList(myList);
                    break;
                case 3:
                    if(!forwad) itr.next();
                    if(itr.hasNext()){
                        //itr.next();
                        System.out.println("playing "+itr.next().getTitle());
                        ans++;
                    }else{
                        System.out.println("Sorry !! You have reached End of the Play List");
                    }
                    forwad=true;
                    break;
                case 4:
                    if(forwad) itr.previous();
                    if(itr.hasPrevious()){
                        //itr.previous();
                        System.out.println("playing "+itr.previous().getTitle());
                        ans--;
                    }else{
                        System.out.println("Sorry !! You are Already at start of the Play List");
                    }
                    forwad=false;
                    break;
                case 5:
                    if(forwad){
                        if(itr.hasPrevious()) {
                            itr.previous();
                            forwad = false;
                        }else {
                            System.out.println("we are at the start of the list");
                    }
                    }else{
                        if(itr.hasNext()) {
                            itr.next();
                            forwad = true;
                        }else{
                            System.out.println("we have reached to the end of list");
                        }
                    }
                    break;
                case 6:
                    if(myList.size()>0) {
                        itr.remove();
                        if (itr.hasNext()) itr.next();
                        else if (itr.hasPrevious()) itr.previous();
                    }
                    else return;
                    break;
                case 7:
                    System.out.println("Have a great day Of music");
                    return;

                    }
            }
    }
    public static void play(LinkedList<Song> playList,int ans) {
        ListIterator<Song> itr = playList.listIterator();
        int k=ans;
        if (!itr.hasNext()) {
            System.out.println("Playlist is empty");
            return;
        }
        while(itr != null && k>1){
            itr.next();
            k--;
        }

        System.out.println("You are now listening " + itr.next());
    }
    public static void printList( LinkedList<Song> myList){

        ListIterator<Song> itr = myList.listIterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        return;
    }
    public static void showMenu(){
        System.out.println("0. play");
        System.out.println("1. Print Menu");
        System.out.println("2. Show the list of all Songs in the playlist");
        System.out.println("3. Play next song");
        System.out.println("4. Play previous Song");
        System.out.println("5. Repeat the song");
        System.out.println("6. Delete the song");
        System.out.println("7. Exit");
    }
}