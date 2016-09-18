package SoftwareTesting.exercise01.QueuePack;

/*
    Author: BARROS, Rubens.
    QueuePack data structure Interface.
    This QueuePack follows its specification in docs directory.
 */

public interface Queue<T> {

    void enqueue(T element) throws Exception ;

    T dequeue() throws Exception;

    T element() throws Exception;

    int size();

    @Override
    public String toString();

    void resetQueue() throws Exception;
}