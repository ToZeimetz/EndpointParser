# Parser.EndpointParser
A SPARQL endpoint parser that uses the http://sparqles.ai.wu.ac.at/ api to find up and running endpoints

## Usage Maven
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

Afterwards your maven will be able to find the following dependency in github. You just need to copy paste this part to your dependencies section and maven will be able to download and use this repository.

```
<!--https://github.com/ToZeimetz/EndpointParser -->
<dependency>
    <groupId>EndpointParser</groupId>
    <artifactId>EndpointParser</artifactId>
    <version>LATEST</version>
</dependency>
```

## Usage Gradle
Just copy and paste the following in you gradle.build file into the repository section.

```
repositories {
    ...

    maven {
        url "https://github.com/ToZeimetz/EndpointParser"
    }
}
```

Afterwards your gradle will be able to find the following dependency in github. You just need to copy paste this part to your dependencies section and gradle will be able to download and use this repository.

```
// https://github.com/ToZeimetz/EndpointParser
compile 'EndpointParser:EndpointParser:LATEST'
```

## How to use in Java
This code is all you need

```
Parser.EndpointParser.getAvailableEndpoints();
```

If you want to display all retrieved (up and running!) sparql endpoints just use the following code.

```
Map<String,String> map = Parser.EndpointParser.getAvailableEndpoints();

int counter = 0;
Iterator<String> it = map.keySet().iterator();
while (it.hasNext()){
    String uri = it.next();
    System.out.println((counter++) + ".\t" + map.get(uri) + ": " + uri);
}
```

