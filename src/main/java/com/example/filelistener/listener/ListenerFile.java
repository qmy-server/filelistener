package com.example.filelistener.listener;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;

public class ListenerFile extends FileAlterationListenerAdaptor {

    private ListenerService listenerService;
    public ListenerFile(ListenerService listenerService){
        this.listenerService=listenerService;
    }
    // 文件创建执行
    @Override
    public void onFileCreate(File file) {
        System.out.println("文件创建执行");
        try {
            listenerService.doSomething(file.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 文件创建修改
    @Override
    public void onFileChange(File file) {
        // 触发业务
        System.out.println("文件创建修改");
    }

    // 文件创建删除
    @Override
    public void onFileDelete(File file) {
        System.out.println("文件创建删除");
    }

    // 目录创建
    @Override
    public void onDirectoryCreate(File directory) {
    }

    // 目录修改
    @Override
    public void onDirectoryChange(File directory) {
    }

    // 目录删除
    @Override
    public void onDirectoryDelete(File directory) {
    }


    // 轮询开始
    @Override
    public void onStart(FileAlterationObserver observer) {
    }

    // 轮询结束
    @Override
    public void onStop(FileAlterationObserver observer) {
    }
}
