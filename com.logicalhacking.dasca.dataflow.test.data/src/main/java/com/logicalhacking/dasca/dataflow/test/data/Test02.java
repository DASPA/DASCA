/*
 * Copyright (c) 2010-2015 SAP SE.
 *               2016-2018 The University of Sheffield.
 * 
 * All rights reserved. This program and the accompanying materials
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package com.logicalhacking.dasca.dataflow.test.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.logicalhacking.dasca.dataflow.test.data.dummy.IO;


// Test Case 02:
// reachability from bad sink to bad source via global boolean constant
public class Test02 {

    private final boolean final_false = false;

    public void bad() {
        String userName;
        if(final_false) {
            userName = "fix";
        } else {
            userName = IO.readLine();
        }
        Connection conn = IO.getDBConnection();
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("SELECT * FROM user WHERE name='" + userName + "';");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void good01() {
        String userName;
        if(final_false) {
            userName =  IO.readLine();
        } else {
            userName = "fix";
        }
        Connection conn = IO.getDBConnection();
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("SELECT * FROM user WHERE name='" + userName + "';");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void good02() {
        String userName =  IO.readLine();

        if(final_false) {
            Connection conn = IO.getDBConnection();
            try {
                Statement stmt = conn.createStatement();
                stmt.execute("SELECT * FROM user WHERE name='" + userName + "';");
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Test02 test = new Test02();
        test.good01();
        test.good02();
        test.bad();
    }
}
