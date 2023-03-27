package ru.gb.patterns.structural.adapter;

public class TvAdapter implements TvAction{

    private final RemoteController remoteController;

    public TvAdapter(RemoteController remoteController){
        this.remoteController = remoteController;
    }

    @Override
    public void on() {
        remoteController.ok();
    }

    @Override
    public void off() {
        remoteController.ok();
    }

    @Override
    public void volumePlus() {
        remoteController.right();
    }

    @Override
    public void volumeMinus() {
        remoteController.left();
    }

    @Override
    public void nextChannel() {
        remoteController.up();
    }

    @Override
    public void prevChannel() {
        remoteController.down();
    }

    @Override
    public void channel(int channel) {
        switch (channel){
            case 1 -> remoteController.one();
            case 2 -> remoteController.two();
        }
    }
}
