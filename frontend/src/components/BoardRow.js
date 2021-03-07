import React from 'react'

import Square from './Square'

function BoardRow(props) {

  let squareValues = props.rowRepresentation.split('')

  return (
    <div className="row">
      {
        squareValues && squareValues.length > 0 && 
          <>
            {
              squareValues.map((squareValue, id) => {
                return <Square 
                                key={id} 
                                color={(id + props.id) % 2 == 0? "white": "black"}
                                lastBoard={props.lastBoard}
                                filled={squareValue == '1'? "true": "false"} />
              })
            }
          </>
      }
    </div>
  )
}

export default BoardRow;