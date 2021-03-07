import React, { useState } from 'react'

import Board from './components/Board'
import BoardRow from './components/BoardRow';

function App() {

  const [n, setN] = useState(0)
  const [boardRepresentations, setBoardRepresentations] = useState([])


  function generateSolutions(e) {
    e.preventDefault();

    fetch("http://localhost:8080/nqeens/" + n, {
      method: 'GET'
    }).then(
      (result) => {
        if (result.status == 200) {
          Promise.resolve(result.json())
            .then(data => {
              console.log("Successfully received data from server.")
              console.log(data)
              setBoardRepresentations(data)
            })
        } else {
          console.log("Result status is: " + result.status)
        }
      }, 
      (error) => {
        console.log("An error occurred.")
      }
    )

    console.log(n);
  }


  return (
    <div className="centered">
      <form>
        <label>Please insert the number of squares (a positive integer): </label>
        <br />
        <input type="number" onChange={e => setN(e.target.value)} />
        <br />
        <input type="submit" onClick={generateSolutions} value="Generate solutions"/>
      </form>

      {
        boardRepresentations && boardRepresentations.length > 0 &&
          <>
            {
              boardRepresentations.map((representation, id) => {
                return <Board key={id} representation={representation} />
              })
            }
          </>
      }
    </div>
  );
}

export default App;
