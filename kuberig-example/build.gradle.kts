import java.time.Duration

plugins {
    id("eu.rigeldev.kuberig")
}

repositories {
    jcenter()
}

kuberig {
    kubernetes("v1.12.8")

    environments {
        create("local") {
            // tested with microk8s
            apiServer = "http://localhost:8080"
        }
        
        create("dev") {
            apiServer = "http://somewhere-else:8080"
        }
    }

    deployControl {
        tickRange = IntRange(1, 2)
        tickDuration = Duration.ofSeconds(10)
        tickGateKeeper = "eu.rigeldev.kuberig.core.deploy.control.DefaultTickGateKeeper"
    }
}