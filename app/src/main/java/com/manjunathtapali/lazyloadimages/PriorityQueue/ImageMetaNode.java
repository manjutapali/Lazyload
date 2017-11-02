package com.manjunathtapali.lazyloadimages.PriorityQueue;

/**
 * Created by tapalim on 9/29/17.
 */

public class ImageMetaNode {

    String ImagePath;
    int priority;
    ImageMetaNode next;

    public ImageMetaNode(){

    }
    public ImageMetaNode(String ImagePath, int priority) {
        this.ImagePath = ImagePath;
        this.priority = priority;
        this.next = null;
    }
    public ImageMetaNode(String ImagePath) {
        this.ImagePath = ImagePath;
        this.priority = 2;
        this.next = null;
    }

    public String getImagePath()
    {
        return ImagePath;
    }

    public int getPriority()
    {
        return priority;
    }
}
