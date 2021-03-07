import React from 'react'

import BoardRow from './BoardRow'

function Board(props) {

  let rowRepresentations = props.representation.split("\n")
  rowRepresentations = rowRepresentations.filter(elem => elem.length > 0)

  return (
    <div className="board">
      {
        rowRepresentations && rowRepresentations.length > 0 && 
          <>
            {
              rowRepresentations.map((row, id) => {
                return <BoardRow 
                                  key={id} 
                                  rowRepresentation={row} 
                                  id={id} 
                                  lastBoard={id == rowRepresentations.length - 1? "true": "false" } />
              })
            }
          </>
      }
    </div>
  )
}

export default Board;
