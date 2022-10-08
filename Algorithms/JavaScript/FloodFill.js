function paintFill(grid, x, y, newColor) {
    let currentVal = grid[x][y];
    // set currentVal to newColor
    grid[x][y] = newColor;

    // check top, bottom, left and right
    // if they match currentVal, call function with that val's coordinates
    // top
    if (x - 1 >= 0 && grid[x-1][y] === currentVal) {
        paintFill(grid, x-1, y, newColor);
    }
    // bottom
    if (x + 1 < grid.length && grid[x + 1][y] === currentVal) {
        paintFill(grid, x+1, y, newColor);
    }
    // left
    if (y - 1 >= 0 && grid[x][y-1] === currentVal) {
        paintFill(grid, x, y-1, newColor);
    }
    // right
    if (y + 1 < grid[x].length && grid[x][y+1] === currentVal) {
        paintFill(grid, x, y+1, newColor)
    }
    return grid;
}

// testing with sample data
const screenGrid = [[1, 1, 1, 1, 1, 1, 1, 1], 
                   [1, 1, 1, 1, 1, 1, 0, 0],
                   [1, 0, 0, 1, 1, 0, 1, 1],
                   [1, 2, 2, 2, 2, 0, 1, 0],
                   [1, 1, 1, 2, 2, 0, 1, 0],
                   [1, 1, 1, 2, 2, 2, 2, 0],
                   [1, 1, 1, 1, 1, 2, 1, 1],
                   [1, 1, 1, 1, 1, 2, 2, 1]];

const newBucket = paintFill(screenGrid, 4, 4, 3);

for (const item of newBucket) {
    console.log(...item);
}
