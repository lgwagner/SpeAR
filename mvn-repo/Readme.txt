This folder is used to hold a local maven repository.  This local maven repository is used to store jar files that 
are not released to a public maven repository (e.g. jkind & jkind-api).

To deploy files to this repository use a command like the following:
  - mvn deploy:deploy-file -DgroupId=jkind -DartifactId=jkind-api -Dversion=4.1.0 -Dpackaging=jar -Dfile=<local-jar-file> -Durl=file:<local-path-to-mvn-repo>
