package com.enjoylearning.mongo.entity;

import java.util.List;

//@Document(collection="comments")
public class Comments {

    private List<Comment> lists;

    public List<Comment> getLists() {
        return lists;
    }

    public void setLists(List<Comment> lists) {
        this.lists = lists;
    }


}
