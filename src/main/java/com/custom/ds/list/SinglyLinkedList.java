package com.custom.ds.list;

import com.custom.ds.list.exception.NodeNullException;
import com.custom.ds.list.operation.ListOperation;
import com.custom.ds.modal.Node;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SinglyLinkedList<E> implements ListOperation<E> {
    Logger logger = Logger.getLogger(SinglyLinkedList.class.getName());
    private Node<E>  headNode;

    @Override
    public void traverseList() {
        Optional.ofNullable(headNode).ifPresent(headNode->{
            StringBuilder output=new StringBuilder();
            Node temp= headNode;int i=1;
            while (temp!=null){
                output.append("\t").append(temp.getData().toString());
                i++;
                temp=temp.getNextNode();
            }
            System.out.println(output.toString());
            temp=null;
            return;
        });
        //logger.log(Level.INFO," List  do not contains any node");

    }



    @Override
    public void insertNewNode( E data, int position) {
        Node<E>  nodeToBeInserted=new Node<>(data);
        int positionCount=0; Node<E>  temp=headNode,temp2=null;

        // insertion at the beginning
        if(position==0){
            nodeToBeInserted.setNextNode(temp);
            headNode=nodeToBeInserted;
            logger.log(Level.INFO," Successfully inserted new node at {0} ",position);
        }else{
            // traverse the list until position-1
            while ( (temp!=null) && (positionCount<=position-1)  ){
                positionCount++;
                temp2=temp;
                temp=temp.getNextNode();
            }
            if(temp==null){  //insert at the end
                if(positionCount==position){
                    temp2.setNextNode(nodeToBeInserted);
                    logger.log(Level.INFO," Successfully inserted new node at {0} ",position);
                }else{
                    logger.log(Level.INFO," Could not find position {0} to insert",position);
                }
            }else{
                temp2.setNextNode(nodeToBeInserted);
                nodeToBeInserted.setNextNode(temp);
                logger.log(Level.INFO," Successfully inserted new node at {0} ",position);
            }
        }
    }

    @Override
    public void deleteByPosition( int position) {
        if(headNode==null){
            logger.log(Level.INFO,"List is Empty Nothing to delete");
            return;
        }
        int positionCount=0;Node<E> temp=headNode,previousNode = null;
        //if position ==0
        if(position==0){
            headNode=temp.getNextNode();
            temp=null;
            return;
        }else{
            while ( (temp!=null) && (positionCount<=position-1)  ){
                positionCount++;
                previousNode=temp;
                temp=temp.getNextNode();
            }

            if(temp==null){
                logger.log(Level.INFO,"Mentioned Position do not exist");
            }else{
                previousNode.setNextNode(temp.getNextNode());
                temp=null;
            }
        }
    }

    @Override
    public void deleteByValue( E data) {

    }
}
