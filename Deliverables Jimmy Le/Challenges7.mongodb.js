use("gadgetStore")
db.createCollection("products", {
    validator: {
        $jsonSchema: {
            bsonType: "object",
            required: ["name", "price", "inStock"],
            //additionalProperties: false, //locks schema. No dynamic typing
            properties: {
                name: {
                    bsonType: "string",
                    description: "must be a string and is required"
                },
                price: {
                    bsonType: ["int", "double"],
                    minimum: 0.00,
                    description: "must be a integer or double greater than 0 and is required"
                },
                inStock: {
                    bsonType: "bool",
                    description: "must be a boolean and is required"
                }
            }
        }
    },
    validationAction: "error" //rejects invalid docs. Can use warn to log warnings
})

use("gadgetStore")
db.products.insertMany(
    [
        {
            name: "Wireless Mouse",
            price: 119.99,
            inStock: true,
            specs: {
                brand: "Logitech"
            }
        },
        {
            name: "Mechanical Keyboard",
            price: 149.99,
            inStock: true,
            specs: {
                brand: "Logitech"
            }
        },
        {
            name: "Gaming Monitor",
            price: 119.99,
            inStock: true,
            specs: {
                brand: "Logitech"
            }
        }   
    ]
)

use("gadgetStore")
db.products.insertOne([
    {
        name: 123,
        price: "Sixy two",
        inStock: 1,
        specs: {
            brand: "Logic Technology"
        }
    }
])


use("gadgetStore")
db.getCollectionInfos({ name: "products" })