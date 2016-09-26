package HW3Package;

/**
 * Created by jennasowers on 9/26/16.
 */
public class Triple<T1, T2, T3> {
    private T1 left;
    private T2 middle;
    private T3 right;

    public Triple(T1 l, T2 m, T3 r)
    {
        this.left = l;
        this.middle = m;
        this.right = r;
    }
    public T1 getLeft() { return left;}
    public void setLeft (T1 left) {this.left = left;}
    public T2 getMiddle() { return middle;}
    public void setMiddle (T2 middle) {this.middle = middle;}
    public T3 getRight() { return right;}
    public void setRight (T3 right) {this.right = right;}

    public String toString()
    {
        return "Left: " + left + ", Middle: " + middle + ", Right: " + right;
    }
}
/*

1. Convert this class to use generics so that you can store any types in a Triple.
The types do not need to match for a Triple. For example,
I should be able to store String, Double, Integer into a single Triple.
2. Write Junit tests to test this class using different data types.
Submission Guidelines:
1. Push your code to github and name your repository as “HW3” and share it with me. a. Username: kyungsooim
2. Take screenshots of your output after running Junit tests, paste it into Word, and upload to Blackboard
 */