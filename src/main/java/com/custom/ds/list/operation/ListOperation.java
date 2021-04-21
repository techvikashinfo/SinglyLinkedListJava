package com.custom.ds.list.operation;

import com.custom.ds.modal.Node;

public interface ListOperation<E> {
     void traverseList();
     void insertNewNode(E data, int position);
     void deleteByPosition(int position);
     void deleteByValue(E data);
}
