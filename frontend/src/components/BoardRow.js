import React from 'react'

import Square from './Square'

function BoardRow(props) {

  return (
    <div className="row">
        <Square color="white" lastBoard={props.lastBoard} filled="true" />
        <Square color="black" lastBoard={props.lastBoard} />
        <Square color="white" lastBoard={props.lastBoard} />
        <Square color="black" lastBoard={props.lastBoard} filled="true" />
    </div>
  )
}

export default BoardRow;