package com.planningboard.dbscripts;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;

import java.util.ArrayList;
import java.util.List;

public class TaskSchemaCreator {
    public final String tableName="Tasks";

    List<AttributeDefinition> attributeDefs() {
        List<AttributeDefinition> attrDefs = new ArrayList<AttributeDefinition>();

        attrDefs.add(DbSchemaHelper.stringAttrDef("plan_id"));
        attrDefs.add(DbSchemaHelper.stringAttrDef("task_id"));
//        attrDefs.add(DbSchemaHelper.stringAttrDef("task_details"));
        return attrDefs ;
    }

    private List<KeySchemaElement> keySchemaElements() {
        List<KeySchemaElement> elements = new ArrayList<KeySchemaElement>();
        elements.add(DbSchemaHelper.keyElement("plan_id", KeyType.HASH));
        elements.add(DbSchemaHelper.keyElement("task_id", KeyType.RANGE));
        return elements;
    }


    public void process() {
        DynamoDB client = DbSchemaHelper.defaultDynamoClient();
        DbSchemaHelper.deleteIfExists(client, this.tableName);
        CreateTableRequest createTableRequest = new CreateTableRequest()
                .withTableName(this.tableName)
                .withProvisionedThroughput(DbSchemaHelper.defaultProvisionedThroughput())
                .withAttributeDefinitions(attributeDefs())
                .withKeySchema(keySchemaElements());

        Table table = client.createTable(createTableRequest);
        try {
            table.waitForActive();
        }catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println(table.getDescription());
    }




    public static void main(String[] args) {
        TaskSchemaCreator schemaCreator = new TaskSchemaCreator();
        schemaCreator.process();
    }
}
