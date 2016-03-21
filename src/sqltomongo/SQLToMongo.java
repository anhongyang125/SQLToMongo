/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqltomongo;

import MongoInterface.MongoDB;
import MongoInterface.MongoQuery;
import SQLParser.Parser;
import org.bson.Document;

/**
 *
 * @author BagusThanatos (github.com/BagusThanatos)
 */
public class SQLToMongo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Parser p = Parser.getSQLParser();
//        System.out.println(p.parse("\"b\""));
        
        System.out.println(p.parse("SELECT user_id, status\n" +
"FROM users\n" +
"WHERE user_id like \"bc%\";")+"\n");
//        System.out.println(p.parse("INSERT INTO users(user_id,\n" +
//"                  age,\n" +
//"                  status)\n" +
//"VALUES (\"bcd001\",\n" +
//"        45,\n" +
//"        \"A\");")+"\n");
//un-comment baris baris di bawah kalo mau konek ke db
        //MongoDB db = new MongoDB();
        //db.setDatabase("db1");
        SQLTranslator.SQLToMongo sqlToMongo = new SQLTranslator.SQLToMongo();
        MongoQuery query = sqlToMongo.translate(p.getTokens());
        System.out.println(query.getFields().toString());
        System.out.println(query.getCond());
//        for(Document d : db.executeQuery(query)){
//            System.out.println(d);
//        }
        
        
    }
    
}
