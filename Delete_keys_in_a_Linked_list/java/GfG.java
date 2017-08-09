/* Linked list Node
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/


/* Author: Loris Reiff
 * 
 * Challenge: Delete keys in a Linked list
 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=700429
 */
class GfG {
    Node deleteAllOccurances(Node head, int x) {
        Node prev = null;
        Node current = head;
        Node newHead = head;

        while (current != null) {
            if(current.data == x) {
                if(prev != null) {
                    prev.next = current.next;
                    current = current.next;
                }
                else {
                    newHead = current.next;
                    current = current.next;
                }
            }
            else {
                prev = current;
                current = current.next;
            }
        }
        return newHead;
    }
}
