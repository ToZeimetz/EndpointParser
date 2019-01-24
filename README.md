# EndpointParser
A SPARQL endpoint parser that uses the http://sparqles.ai.wu.ac.at/ api to find up and running endpoints

## Usage
Just copy and paste the following in you pom.xml file. 

```
<repositories>
    <repository>
        <id>tozeimetz</id>
        <url>https://github.com/ToZeimetz/EndpointParser</url>
        <snapshots>
            <enabled>true</enabled>
            <updatePolicy>always</updatePolicy>
        </snapshots>
    </repository>
</repositories>
```

The same structure would also work in gradle! Afterwards your maven will be able to find this repository as dependency. You just need to copy paste the following in your dependencies section.

```
<!--https://github.com/ToZeimetz/EndpointParser -->
<dependency>
    <groupId>EndpointParser</groupId>
    <artifactId>EndpointParser</artifactId>
    <version>LATEST</version>
</dependency>
```
