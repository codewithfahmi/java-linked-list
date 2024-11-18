package core;

public class DoubleLinkedList<T> {
  private static class Node<T> {
    T item;
    Node<T> next;
    Node<T> previous;

    public Node(T item) {
      this.item = item;
      this.next = null;
      this.previous = null;
    }
  }

  private Node<T> head = null;
  private Node<T> tail = null;

  public void addFirst(T item) {
    Node<T> node = new Node<>(item);
    if (this.head == null) {
      this.head = node;
      this.tail = node;
    } else {
      node.next = this.head;
      this.head.previous = node;
      this.head = node;
    }
  }

  public void addLast(T item) {
    Node<T> node = new Node<>(item);
    if (this.tail == null) {
      this.tail = node;
      this.head = node;
    } else {
      this.tail.next = node;
      node.previous = this.tail;
      this.tail = node;
    }
  }

  public void add(T item, int index) {
    if (index < 0 || index > this.size()) {
      System.out.println("[WARN] index must be between 0 - " + this.size() + ", data: "
          + item.toString().substring(0, 32) + "...");
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
    while (currentNode != null && counter < index - 1) {
      currentNode = currentNode.next;
      counter++;
    }

    node.next = currentNode.next;
    currentNode.next.previous = node;
    currentNode.next = node;
    node.previous = currentNode;
  }

  public T removeFirst() {
    if (this.head == null) {
      System.out.println("[WARN] Can't operate deletion (removeFirst), list is empty!");
    }

    T item = null;
    if (this.head != null) {
      item = this.head.item;
      this.head = this.head.next;
    }

    if (this.head == null) {
      this.tail = null;
    } else {
      this.head.previous = null;
    }

    return item;
  }

  public T removeLast() {
    if (this.tail == null) {
      System.out.println("[WARN] Can't operate deletion (removeLast), list is empty!");
    }

    T item = null;
    if (this.tail != null) {
      item = this.tail.item;
      this.tail = this.tail.previous;
    }

    if (this.tail == null) {
      this.head = null;
    } else {
      this.tail.next = null;
    }

    return item;
  }

  public T remove(int index) {
    if (this.head == null) {
      System.out.println("[WARN] Can't operate deletion (remove), list is empty!");
    }

    if (index < 0 || index >= this.size()) {
      if (this.head != null) {
        System.out.println("[WARN] index must be between 0 - " + (this.size() - 1));
      }
      return null;
    }

    if (index == 0) {
      return this.removeFirst();
    }

    if (index == this.size() - 1) {
      return this.removeLast();
    }

    T item = null;

    Node<T> currentNode = this.head;
    int counter = 0;

    while (currentNode != null && counter < index) {
      currentNode = currentNode.next;
      counter++;
    }

    item = currentNode.item;
    currentNode.previous.next = currentNode.next;
    currentNode.next.previous = currentNode.previous;
    currentNode = null;

    return item;
  }

  public int size() {
    int counter = 0;
    Node<T> currentNode = this.head;
    while (currentNode != null) {
      counter++;
      currentNode = currentNode.next;
    }
    return counter;
  }

  public void showForward() {
    if (this.head != null) {
      int counter = 0;
      Node<T> currentNode = this.head;
      while (currentNode != null) {
        System.out.printf("%d: %s\n", counter, currentNode.item.toString());
        currentNode = currentNode.next;
        counter++;
      }
    } else {
      System.out.println("List is empty!");
    }
  }

  public void showBackward() {
    if (this.tail != null) {
      int counter = 0;
      Node<T> currentNode = this.tail;
      while (currentNode != null) {
        System.out.printf("%d: %s\n", counter, currentNode.item.toString());
        currentNode = currentNode.previous;
        counter++;
      }
    } else {
      System.out.println("List is empty!");
    }
  }
}
