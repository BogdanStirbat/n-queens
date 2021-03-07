import React from 'react'

import BoardRow from './BoardRow'

function Board(props) {

  return (
    <div className="board">
      <BoardRow />
      <BoardRow />
      <BoardRow />
      <BoardRow lastBoard="true" />
    </div>
  )
}

export default Board;
