0) To deploy a project run "mvn spring-boot:run"
1) There is a converter api:

    localhost:8080/converter

2) Json object for sending:
    {
        "value":"500",
        "sourceType":"METRES",
        "targetType":"KELVIN"
    }
    
3) This converter allows you to convert values that have these types:
    
    DistanceType : "METRES", "MILES";
    TemperatureType : "CELSIUS", "FAHRENHEIT", "KELVIN";
    WeightType : "GRAMS", "POUNDS";
 
 