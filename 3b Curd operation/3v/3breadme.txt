FIRST INSTALL
1.MONGODB COMPASS
2.MONGODB POSTMAN
3.MONGODB SERVER
STEP
1. CREATE FOLDER WAD.OPEN FOLDER WAD AND CREATE SUBFOLDER ASSIGNMENT3B.
2. OPEN FOLDER IN VSC
3. OPEN TERMINAL IN VSC FOR CREATE PACKAGE.JSON FILE
4. WRITE npm init then enter..........enter upto create package.json file
5. CREATE INDEX.JS FILE IN ASSIGNMENT3B FOLDER
6. OPEN MONGODB COMPASS AND CONNECT THIS AND OPEN MONGODB POSTMAN
7. OPEN MONGODB COMPASS TERMINAL & CREATE DATABASE USING FOLLOWING COMMANDS
8. show dbs THEN ENTER
9. use student THEN ENTER
10.db.createCollection("profile") THEN ENTER
11.db.profile.insertOne({name:"amol",email:"amol@gmail.com",city:"pune"})
THEN ENTER
12.CHEAK THE DATABASE AND REFRESH
13.THEN GOES VSC AND CREATE FILE mongodb.js in ASSIGNMENT3B FOLDER
14.AFTER THAT OPEN TERMINAL IN VSC ENTER FOLLING COMMAND
15.1. npm i mongodb THEN ENTER 2. npm i express THEN ENTER
16.AFTER THAT OPEN FILE mongodb.js & write following code

const {MongoClient}=require("mongodb");
const url="mongodb://localhost:27017"
const database='student';
const client=new MongoClient(url);
const dbConnect=async()=>{
const result=await client.connect();
const db=await result.db(database);
return db.collection('profile');
}
module.exports=dbConnect;

17.THEN OPEN FILE index.js & WRITE FOLLOWING CODE

const dbConnect = require("./mongodb")
const express = require("express");
const response= require("express");
const app=express();
app.use(express.json())
//get API
app.get('/',async(req, res)=>{
let result=await dbConnect();
result=await result.find().toArray();
res.send(result);
})
app.listen(3000);

18.SAVE FILE THEN GO TO TERMINAL AND RUN CODE USING COMMAND node inde.js
19.THEN GO TO MONGODB COMPASS

20.WRITE localhost:3000 in MONGODB COMPASS AND SEND THIS
21.OUTPUT IS DATA INSERTED SUCCESFULLY
22.THEN PERFORM PUT OPERATION
23.GOTO VSC OPEN index.js file & ADD CODE POST API
//post API

app.post("/",async(req, res)=>{
let result= await dbConnect();
result= await result.insertOne(req.body);
res.send("Data inserted Successfully");
})

24.SAVE THIS FILE GOTO POSTMAN SELECT POST OPTION GO TO POSTMAN SELECT POST
OPTION THEN BODY OPTION TNEN JSON OPTION

25.WRITE FOLLOWING LINES IN BODY
{
"name":"amol",
"email":"amol@gmail.com",
"city":"mumbai"
}

26.THEN GOTO VSC AND RUN THE FILE node index.js
27.THEN GOTO POSTMAN SELECT POST OPTION AND SEND REQUES
28.THEN PERFORM PUT OPERATION
29.OPEN index.js file and add PUT API CODE

// PUT API
app.put('/:name', async(req, res) => {
let result = await dbConnect();
result = await result.updateOne({name:req.params.name}, {$set:req.body});
res.send(`Data updated successfully`)
})
27. RUN THIS CODE node.index.js GO TO POSTMAN & SELECT PUT OPTION & CHANGES IN
BODY FILE AND SEND REQUEST
28.THEN PERFORM PUT OPERATION
// DELETE API
app.delete("/:name", async(req, res) => {
let result = await dbConnect();
result = await result.deleteOne({name:req.params.name});
res.send("Data deleted successfully");
})
29.SAVE THIS FILE & RUN THIS FILE node.index.js THEN GOTO POSTMAN AND SELECT
DELETE OPTION AND SEND REQUEST
30.CHEAK THIS OUTPUT IN MONGODB COMPASS




1)index.js
const dbConnect = require("./mongodb")
const express = require("express");
const response= require("express");
const app=express();
app.use(express.json())

//get API

app.get('/',async(req, res)=>{
let result=await dbConnect();
result=await result.find().toArray();
res.send(result);
})
app.listen(3000);

//post API
app.post("/",async(req, res)=>{
let result= await dbConnect();
result= await result.insertOne(req.body);
res.send("Data inserted Successfully");
})

// PUT API
app.put('/:name', async(req, res) => {

let result = await dbConnect();
result = await result.updateOne({name:req.params.name}, {$set:req.body});
res.send("Data updated successfully")
})

// DELETE API
app.delete("/:name", async(req, res) => {

let result = await dbConnect();
result = await result.deleteOne({name:req.params.name});
res.send("Data deleted successfully");
})

2)mongodb.js
const {MongoClient}=require("mongodb");
const url="mongodb://localhost:27017"
const database='student';
const client=new MongoClient(url);

const dbConnect=async()=>{
const result=await client.connect();
const db=await result.db(database);
return db.collection('profile');
}
module.exports=dbConnect;