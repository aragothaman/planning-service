package com.planningboard.dbscripts;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;

public class DbSchemaHelper {
    final static String serviceEndpoint = "http://localhost:8000";
    final static String region = "us-west-2";

    static KeySchemaElement keyElement(String keyId, KeyType keyType) {
        return new KeySchemaElement()
                .withAttributeName(keyId)
                .withKeyType(keyType);
    }

    static AttributeDefinition stringAttrDef(String attrName) {
        return new AttributeDefinition()
                .withAttributeName(attrName)
                .withAttributeType("S");
    }

    public static void deleteIfExists(DynamoDB client, String tableName) {
        Table table = client.getTable(tableName);
        try {
            if(table != null) {
                System.out.println("Attempting to delete table; please wait...");
                table.delete();
                table.waitForDelete();
                System.out.print("Success Deleting");
            }
        }catch (Exception e) {
            System.err.println("Unable to delete table: ");
            System.err.println(e.getMessage());
        }
    }

    public static DynamoDB getDynamoDB(String serviceEndpoint, String signingRegion) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(serviceEndpoint, signingRegion))
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);
        return dynamoDB ;
    }

    public static DynamoDB defaultDynamoClient(){
        return getDynamoDB(DbSchemaHelper.serviceEndpoint, DbSchemaHelper.region);
    }

    static ProvisionedThroughput defaultProvisionedThroughput() {
        return new ProvisionedThroughput()
                .withReadCapacityUnits((long) 5)
                .withWriteCapacityUnits((long) 1);
    }
}
