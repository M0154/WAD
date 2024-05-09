create folder on Desktop
open with vscode
on terminal cd foldername
npm init
go to express website > getting started > Installing > use commands
npm install express
create two file index.js and write code from website > getting started >Helloworld

const express = require('express')
const app = express()
const port = 3000

app.get('/', (req, res) => {
  res.send('Hello World!')
})

app.get('/home', (req, res) => {
    res.sendFile('./index.html', {root:__dirname})
  })

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})


create file index.html write content in body 

run as >   node .\index.js    
on browser search localhost:3000(portno.)

//app.get('/home', (req, res) => {
search localhost:3000/home(portno.)