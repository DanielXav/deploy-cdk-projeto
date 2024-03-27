package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

import java.util.Arrays;

public class ProjetoAluraInfraApp {
    public static void main(final String[] args) {
        App app = new App();

        VpcStack vpcStack = new VpcStack(app, "Vpc");
        ClusterStack clusterStack = new ClusterStack(app, "Cluster", vpcStack.getVpc());
        clusterStack.addDependency(vpcStack); // Cluster precisa que a VPC esteja criada primeiramente
        ServiceStack serviceStack = new ServiceStack(app, "Service", clusterStack.getCluster());
        serviceStack.addDependency(clusterStack);
        app.synth();
    }
}

