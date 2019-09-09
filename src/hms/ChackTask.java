/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import javafx.concurrent.Task;

/**
 *
 * @author Administrator
 */
public class ChackTask extends Task<Boolean> {

    @Override
    protected Boolean call() throws Exception {
        Thread.sleep(2000);
        updateProgress(1, 1);
        return null;
    }

}
