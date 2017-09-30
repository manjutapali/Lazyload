package com.manjunathtapali.lazyloadimages.PriorityQueue;

import android.util.Log;

/**
 * Created by tapalim on 9/29/17.
 */

public class PriorityQueue {

    private ImageMetaNode head;
    private ImageMetaNode PriorityHIGHEnd;
    private ImageMetaNode PriorityHIGHStart;
    private ImageMetaNode PriorityMEDIUMEnd;
    private ImageMetaNode PriorityMEDIUMStart;
    private ImageMetaNode PriorityLOWEnd;
    private ImageMetaNode PriorityLOWStart;

    public enum Priority {HIGH, MEDIUM, LOW};

    public PriorityQueue() {

    }

    public void add(String url, Priority priority)
    {

        insert(url, priority);
    }

    private void insert(String url, Priority priority)
    {
        int prior = getPriorityNum(priority);

        switch (priority)
        {
            case HIGH:
                System.out.println("High");
                if(PriorityHIGHStart == null)
                {
                    ImageMetaNode newNode = new ImageMetaNode(url, prior);
                    PriorityHIGHStart = newNode;
                    head = PriorityHIGHStart;
                    PriorityHIGHEnd = PriorityHIGHStart;
                }
                else
                {
                    PriorityHIGHEnd.next = new ImageMetaNode(url, prior);
                    PriorityHIGHEnd = PriorityHIGHEnd.next;
                    UpdateEnds();
                }
                break;
            case MEDIUM:
                System.out.println("Medium");
                if(PriorityMEDIUMStart == null)
                {
                    ImageMetaNode newNode = new ImageMetaNode(url, prior);
                    PriorityMEDIUMStart = newNode;
                    PriorityMEDIUMEnd = PriorityMEDIUMStart;
                }
                else
                {
                    PriorityMEDIUMEnd.next = new ImageMetaNode(url, prior);
                    PriorityMEDIUMEnd = PriorityMEDIUMEnd.next;
                    UpdateEnds();
                }
                break;
            case LOW:
                System.out.println("Low");
                if(PriorityLOWStart == null)
                {
                    ImageMetaNode newNode = new ImageMetaNode(url, prior);
                    PriorityLOWStart = newNode;
                    PriorityLOWEnd = PriorityLOWStart;
                }
                else
                {
                    PriorityLOWEnd.next = new ImageMetaNode(url, prior);
                    PriorityLOWEnd = PriorityLOWEnd.next;
                    UpdateEnds();
                }
                break;
        }

    }

    private void UpdateEnds()
    {
        if(PriorityMEDIUMStart != null)
            PriorityHIGHEnd.next = PriorityMEDIUMStart;
        else if(PriorityLOWStart != null)
            PriorityHIGHEnd.next = PriorityLOWStart;

        if(PriorityMEDIUMStart != null)
            PriorityMEDIUMEnd.next = PriorityLOWStart;

        if(PriorityLOWStart != null)
            PriorityLOWEnd.next = null;
    }
    private int getPriorityNum(Priority priority)
    {

        switch (priority){
            case HIGH:
                return 0;
            case MEDIUM:
                return 1;
            case LOW:
                return 2;
        }

        return -1;
    }

    public void Display()
    {
        if(head == null)
        {
            Log.e("Priority queue","List head is null");
            return;
        }

        ImageMetaNode runnr = head;
        int count = 1;
        while (runnr != null)
        {
            Log.d("List contents", count + "  " + runnr.priority + "  " + runnr.ImagePath);
            runnr = runnr.next;
            count++;
        }
    }
}