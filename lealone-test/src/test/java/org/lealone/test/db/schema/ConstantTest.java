/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.lealone.test.db.schema;

import org.junit.Test;
import org.lealone.test.db.DbObjectTestBase;

public class ConstantTest extends DbObjectTestBase {

    @Test
    public void run() {
        create();
        drop();
    }

    void create() {
        executeUpdate("CREATE CONSTANT IF NOT EXISTS ConstantTest VALUE 10");
        assertNotNull(schema.findConstant("ConstantTest"));

        sql = "select ConstantTest";
        assertEquals(10, getInt(sql, 1));
    }

    void drop() {
        executeUpdate("DROP CONSTANT IF EXISTS ConstantTest");
        assertNull(schema.findConstant("ConstantTest"));
    }

}
