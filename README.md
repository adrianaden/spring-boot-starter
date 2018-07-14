### Quick start
** Make sure you have Maven and JDK Version >= 1.8 **
> Clone/Download the repo then edit in controller / service / repository

```bash
# clone our repo
# --depth 1 removes all but one .git commit history
git clone https://github.com/adrianaden/spring-boot-starter.git

# change directory to our repo
cd spring-boot-starter

# install the repo with mvn
mvn install

# start the application
npm spring-boot:run
```
go to [http://localhost:8081/api](http://localhost:8081/api) in your browser or Postman (or the other similar app)

## File Structure
<<<<<<< HEAD
We are using Controller, Service, Repository layer in our this starter, this is way to ensure maintainable code based on behavior for each layer.
```
springboot.starter/
=======

```
springboot.tarter/
>>>>>>> 040ced53304d17f0443dad14b1a1bd482c5ff836
 ├─common/                          * our common files
 │   ├──Constant                    * our files to maintain constant variables
 │   └──Tool                        * our files to maintain static/ reusable methods
 │
 ├──config/                         * our configuration files
 │   └──SwaggerConfig               * configuration file to configure swagger documentation
 │
 ├──dto                             * our DTO(Data Transfer Object) files
<<<<<<< HEAD
 │   ├──FailureResponse             * our JSON format that return by exception handler
 │   ├──SuccessResponse             * our JSON format that return is transaction/ process is success
 │   └──Response                    * our JSON standard JSON format
 │
 ├──exception                       * our custom exception files and exception handler
 │   └──HandlerException            * our runtime exception handler that return a nice JSON
 │
 ├──interceptor                     * our filter files
 │   ├──Interceptor                 * our main Interceptor
 │   └──LogInterceptor              * our pre and post handle that log activity in web service
 │
=======
 ├──exception                       * our custom exception files and exception handler
 ├──interceptor                     * our filter files
>>>>>>> 040ced53304d17f0443dad14b1a1bd482c5ff836
 ├──entity                          * our entity files that mapping to table in database
 │   └──Person                      * our object mapping table Person
 │
 ├──controller                      * our controller files that define endpoints/ route mapping
 │   └──PersonController            * our endpoint to handle Person module
 │
 ├──service                         * our service files to handle business logic
 │   └──PersonService               * our logic to handle Person module
 │
 └──repository                      * out repository files to handle query / command to database
     └──PersonRepository            * our query related with table Person

```
