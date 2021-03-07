import React from 'react'

function Square(props) {
  
  let className = "square "
  if (props.color == 'black') {
    className += "black-square "
  }
  if (props.lastBoard == "true") {
    className += "last-row"
  }
  
  return (
    <div className={className}>
      {props.filled == "true"? String.fromCharCode(9813): ''}
    </div>
  )
}

export default Square;