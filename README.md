This repository is a solution to the n-queens problem. In addition to the constraint that no 2 queens should attack each other, this solution also checks that no 3 queens can form an angle, at any given slope.

This repository consists of a backend application (that actually solves the problem) and a frontend application (a solution visualizer) . To view solutions in the browser, you need to start both applications.

To start the backend application, go to the `backend/nqueens` folder and run:
 - `./gradlew build`
 - `java -jar build/libs/nqueens-0.0.1-SNAPSHOT.jar`

 Now, the backend application is running, and solutions can be generating by accessing `http://localhost:8080/nqeens/<number of squares>` . 

 To start the frontend application, go to the `frontend` folder and run:
 - `npm start`

 Now, the solution visualizer is available at `http://localhost:3000/` .