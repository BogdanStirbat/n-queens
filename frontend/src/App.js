import React, { useState } from 'react'

import Board from './components/Board'

function App() {

  const [n, setN] = useState(0)
  const [boardRepresentations, setBoardRepresentations] = useState([])
  const [requestInProgress, setRequestInProgress] = useState(false)
  const [errorMessage, setErrorMessage] = useState('')
  const [nrSolutionsMessage, setNrSolutionsMessage] = useState('')


  function generateSolutions(e) {
    e.preventDefault();

    if (parseInt(n) <= 0) {
      setErrorMessage("Please insert a valid positive integer.")
      return
    }

    if (parseInt(n) > 14) {
      if (!prompt("This computation will take a lot of time. Are you sure you want to continue? You're better of mining bitcoin instead ...")) {
        return
      }
    }

    setRequestInProgress(true)

    fetch("http://localhost:8080/nqeens/" + n, {
      method: 'GET'
    }).then(
      (result) => {
        if (result.status == 200) {
          Promise.resolve(result.json())
            .then(data => {
              setBoardRepresentations(data)
              setNrSolutionsMessage('Number of solutions: ' + data.length)
              setRequestInProgress(false)
            })
        } else {
          setErrorMessage("Retrieving solutions from server failed, respose status: " + result.status)
          setRequestInProgress(false)
        }
      }, 
      (error) => {
        setErrorMessage("An error occurred while retrieving data from the server.")
        setRequestInProgress(false)
      }
    )
  }


  return (
    <div className="centered">
      <form>
        <label>Please insert the number of squares (a positive integer): </label>
        <br />
        {
          errorMessage && errorMessage.length > 0 &&
            <div className="error-message">
              <p>{errorMessage}</p>
            </div>
        }
        <input type="number" onChange={e => {setN(e.target.value); setErrorMessage('')}} />
        <br />
        <input type="submit" onClick={generateSolutions} value="Generate solutions"/>
        {
          requestInProgress && 
            <>
              <p>Retrieving solutions from server, please wait ...</p>
            </>
        }
      </form>
      
      {
        nrSolutionsMessage && nrSolutionsMessage.length > 0 &&
          <>
            <p>{nrSolutionsMessage}</p>
          </>
      }
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
