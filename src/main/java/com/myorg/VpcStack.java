package com.myorg;

import software.constructs.Construct;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.Vpc;
import java.util.Arrays;
import software.amazon.awscdk.services.ec2.SubnetConfiguration;
import software.amazon.awscdk.services.ec2.SubnetType;

public class VpcStack extends Stack {

    private Vpc vpc;

    public VpcStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public VpcStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        this.vpc = Vpc.Builder.create(this, "AluraVpc")
                .maxAzs(3)
                .natGateways(0) // Nenhum NAT Gateway deve ser criado
                .subnetConfiguration(Arrays.asList(
                        SubnetConfiguration.builder()
                                .name("public")
                                .subnetType(SubnetType.PUBLIC)
                                .build(),
                        SubnetConfiguration.builder()
                                .name("private-isolated")
                                .subnetType(SubnetType.PRIVATE_ISOLATED)
                                .build()))
                .build();
    }

    public Vpc getVpc() {
        return vpc;
    }
}
