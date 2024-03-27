package com.myorg;

import software.constructs.Construct;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ecs.Cluster;
import software.amazon.awscdk.services.ec2.Vpc;
import software.amazon.awscdk.services.ec2.SubnetSelection;
import software.amazon.awscdk.services.ec2.SubnetType;

public class ClusterStack extends Stack {

    private Cluster cluster;

    public ClusterStack(final Construct scope, final String id, final Vpc vpc) {
        this(scope, id, null, vpc);
    }

    public ClusterStack(final Construct scope, final String id, final StackProps props, final Vpc vpc) {
        super(scope, id, props);

        Cluster cluster = Cluster.Builder.create(this, "AluraCluster")
                .clusterName("cluster-alura")
                .vpc(vpc)
                .build();

    }

    public Cluster getCluster(){
        return cluster;
    }
}
