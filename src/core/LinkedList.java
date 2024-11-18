package core;

public class LinkedList<T> {
  private static class Node<T> {
    T item;
    Node<T> next;

    public Node(T item) {
      this.item = item;
      this.next = null;
    }
  }

  private Node<T> head = null;

  public void addFirst(T item) {
    Node<T> node = new Node<>(item);
    node.next = this.head;
    this.head = node;
  }

  public void addLast(T item) {
    if (this.head == null) {
      this.addFirst(item);
      return;
    }

    Node<T> node = new Node<>(item);

    Node<T> currentNode = this.head;
    while (currentNode.next != null) {
      currentNode = currentNode.next;
    }

    currentNode.next = node;
  }

  public void add(T item, int index) {
    if (index < 0 || index > this.size()) {
      System.out.println("[WARN] index must be between 0 - " + this.size() + ", data: "
          + item.toString().substring(0, 32) + "...");
      return;
    }

    if (index == 0) {
      this.addFirst(item);
      return;
    }

    if (index == this.size()) {
      this.addLast(item);
      return;
    }

    Node<T> node = new Node<>(item);
    Node<T> currentNode = this.head;
    int counter = 0;

    while (counter < index - 1 && currentNode != null) {
      currentNode = currentNode.next;
      counter++;
    }

    node.next = currentNode.next;
    currentNode.next = node;
  }

  public T removeFirst() {

    if (this.head == null)
      return null;

    T item = this.head.item;
    this.head = this.head.next;
    return item;
  }

  public T removeLast() {
    if (this.head == null)
      return null;

    if (this.head.next == null) {
      T item = this.head.item;
      this.head = null;
      return item;
    }

    Node<T> currentNode = this.head;
    while (currentNode.next.next != null)
      currentNode = currentNode.next;
    T item = currentNode.next.item;
    currentNode.next = null;
    return item;
  }

  public T remove(int index) {
    if (this.head == null) {
      return null;
    }

    if (index < 0 || index >= this.size()) {
      System.out.println("[WARN] index must be between 0 - " + this.size());
      return null;
    }

    if (index == 0) {
      return this.removeFirst();
    }

    if (index == this.size() - 1) {
      return this.removeLast();
    }

    Node<T> currentNode = this.head;
    int counter = 0;

    while (counter < index - 1 && currentNode != null) {
      currentNode = currentNode.next;
      counter++;
    }

    T item = currentNode.next.item;
    currentNode.next = currentNode.next.next;
    return item;
  }

  public int size() {
    int count = 0;
    Node<T> currentNode = this.head;
    while (currentNode != null) {
      count++;
      currentNode = currentNode.next;
    }

    return count;
  }

  public void show() {
    Node<T> currentNode = this.head;
    int index = 0;
    while (currentNode != null) {
      System.out.println(index + ": " + currentNode.item.toString());
      currentNode = currentNode.next;
      index++;
    }
  }
}
