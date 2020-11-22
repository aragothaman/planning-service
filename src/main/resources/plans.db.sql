aws dynamodb create-table \
		--table-name Plans \
		--attribute-definitions \
			AttributeName=WorkspaceId,AttributeType=S \
			AttributeName=Name,AttributeType=S \
		--key-schema AttributeName=WorkspaceId,KeyType=HASH AttributeName=Name,KeyType=RANGE \
		--provisioned-throughput ReadCapacityUnits=1,WriteCapacityUnits=1 \
		--endpoint-url http://localhost:8000


aws dynamodb --endpoint-url http://localhost:8000 put-item \
    --table-name Plans  \
    --item \
        '{"WorkspaceId": {"S": "10000"}, "Name": {"S": "Authentication Team"}, "PlanId": {"S": "10000"}}' \
    --return-consumed-capacity TOTAL

aws dynamodb --endpoint-url http://localhost:8000 put-item \
    --table-name Plans  \
    --item \
        '{"WorkspaceId": {"S": "10000"}, "Name": {"S": "Authentication Q3 Plan"}, "PlanId": {"S": "20000"}}' \
    --return-consumed-capacity TOTAL

//localhost
aws dynamodb --endpoint-url http://localhost:8000 scan --table-name Plans
aws dynamodb --endpoint-url http://localhost:8000 query --table-name Workspaces

//aws account
aws dynamodb scan --table-name Workspaces

aws dynamodb query --table-name Workspaces

aws dynamodb --endpoint-url http://localhost:8000 scan --table-name Workspaces

aws dynamodb --endpoint-url http://localhost:8000 delete-table --table-name Workspaces

--key-conditions file://key-conditions.json