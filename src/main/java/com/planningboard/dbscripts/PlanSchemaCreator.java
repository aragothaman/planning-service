package com.planningboard.dbscripts;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;

import java.util.ArrayList;
import java.util.List;

public class PlanSchemaCreator {
    final String serviceEndpoint = "http://localhost:8000";
    final String tableName = "Plans";
    final String region = "us-west-2";

    public PlanSchemaCreator() {

    }

    DynamoDB client() {
        final String serviceEndpoint = this.serviceEndpoint;
        final String signingRegion = "us-west-2";
        return DbSchemaHelper.getDynamoDB(serviceEndpoint, signingRegion);
    }

    List<AttributeDefinition> attributeDefs() {
        List<AttributeDefinition> attrDefs = new ArrayList<AttributeDefinition>();

        final String workspace_id = "workspace_id";
        attrDefs.add(DbSchemaHelper.stringAttrDef(workspace_id));
        attrDefs.add(DbSchemaHelper.stringAttrDef("plan_name"));
        attrDefs.add(DbSchemaHelper.stringAttrDef("plan_id"));
        return attrDefs ;
    }

    List<KeySchemaElement> keySchemaElements() {
        ArrayList<KeySchemaElement> tableKeySchema = new ArrayList<KeySchemaElement>();

        final String workspace_id = "workspace_id";
        tableKeySchema.add(DbSchemaHelper.keyElement(workspace_id, KeyType.HASH));
        tableKeySchema.add(DbSchemaHelper.keyElement("plan_name", KeyType.RANGE));

        return tableKeySchema;
    }

    List<KeySchemaElement> indexSchemaElement() {
        ArrayList<KeySchemaElement> indexKeySchema = new ArrayList<KeySchemaElement>();
        indexKeySchema.add(DbSchemaHelper.keyElement("plan_id", KeyType.HASH));
        return indexKeySchema;
    }

    GlobalSecondaryIndex secondaryIndex() {
        GlobalSecondaryIndex planIdIndex = new GlobalSecondaryIndex()
                .withIndexName("PlanIdIndex")
                .withProvisionedThroughput(new ProvisionedThroughput()
                        .withReadCapacityUnits((long) 10)
                        .withWriteCapacityUnits((long) 1))
                .withProjection(new Projection().withProjectionType(ProjectionType.ALL));

        planIdIndex.setKeySchema(indexSchemaElement());

        return planIdIndex ;
    }

    public void process() {
        DbSchemaHelper.deleteIfExists(client(), this.tableName);
        CreateTableRequest createTableRequest = new CreateTableRequest()
                .withTableName(this.tableName)
                .withProvisionedThroughput(new ProvisionedThroughput()
                        .withReadCapacityUnits((long) 5)
                        .withWriteCapacityUnits((long) 1))
                .withAttributeDefinitions(attributeDefs())
                .withKeySchema(keySchemaElements())
                .withGlobalSecondaryIndexes()
                .withGlobalSecondaryIndexes(secondaryIndex());

        Table table = client().createTable(createTableRequest);
        try {
            table.waitForActive();
        }catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println(table.getDescription());
    }


    public static void main(String[] args) {
        PlanSchemaCreator schemaCreator = new PlanSchemaCreator();
        schemaCreator.process();
    }
}