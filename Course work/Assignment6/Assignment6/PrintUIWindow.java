 /*******************************************************************************
 *                            Assignment 4 - Yahtzee Hand                       *
 *                                                                              *
 * PROGRAMMER:       Ben McEwen                                                 *
 * CLASS:            CS102                                                      *
 * ASSIGNMENT:       Assignment assign-4                                        *
 * INSTRUCTOR:       Dean Zeller                                                *
 * SUBMISSION DATE:  2/22/2019                                                  *
 *                                                                              *
 * DESCRIPTION:                                                                 *
 * This defines the class which is used a blueprint when creating a die object. *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen and Dean Zeller. This is       *
 * original work, without use of outside sources.                               *
 *******************************************************************************/

 /*******************************************************************************
 * CREDITS:                                                                     *
 * The following sources were used in completion with this program.             *
 *      PROGRAM:     PrintUIWindow.java                                         *
 *      PROGRAMMER:  Oracle                                                     *
 *      LOCATION:    https://docs.oracle.com/javase/tutorial/2d/printing/       *
 *                  examples/PrintUIWindow.java                                 *
 *      MODIFICATIONS:                                                          *
 *          Refactored for personal preference of styling,                      *
 *          moved call to print to AnalysisEngine file,                         *
 *          renamed variables as necessary to work with existing code.          *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 your-name and Dean Zeller. This is        *
 * original work, making use of the above sources.                              *
 *******************************************************************************/


/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.print.*;

public class PrintUIWindow implements Printable, ActionListener
{
    JFrame frameToPrint;

    public int print(Graphics g, PageFormat pf, int page)
    {
        if (page > 0)
        {
            return NO_SUCH_PAGE;
        }
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        // prints the window and its visible contents
        frameToPrint.printAll(g);

        //tells the caller that this page is part of the printed document
        return PAGE_EXISTS;
    }

    public void actionPerformed(ActionEvent e)
    {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean ok = job.printDialog();
        if (ok)
        {
            try
            {
                job.print();
            }
            catch (PrinterException ex)
            {
                // The job did not successfully complete
                System.out.println("An error has occurred");
            }
        }
    }

    public PrintUIWindow(JFrame f)
    {
        frameToPrint = f;
    }
}