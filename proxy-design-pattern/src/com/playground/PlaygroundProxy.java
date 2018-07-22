package com.playground;

public final class PlaygroundProxy implements PlaygroundInterface  {
    private PlaygroundInterface proxy;
    private boolean isUnderAge;
    public PlaygroundProxy(int childAge)    {
        if (childAge < 18)  {
            isUnderAge = true;
        }
        else    {
            isUnderAge = false;
        }
        proxy = new PlaygroundImpl();
    }

    public void runOnTrack()    {
        System.out.println("Run around court track");
    }

    @Override
    public void play() {
        if(isUnderAge)  {
            proxy.play();
        }
        else    {
            runOnTrack();
        }
    }
}