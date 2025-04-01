# Stock-Calculator

FIFO and LIFO
accounting used for determining the “cost” of a stock. This
information is typically calculated when a stock is sold to determined if
a profit or loss was made. In our version of FIFO accounting, the price
of a stock is averaged starting with the first purchase of that item.
Say we sell 250 shares of a stock, according to this method the
purchase price is determined by averaging the prices on the first 250
shares bought. In our version of LIFO accounting, the price of a
commodity is averaged starting with the last purchase of that item.
Say we sell 250 shares of a stock, according to this method the
purchase price is determined by averaging the prices on the last 250
shares bought.
We decided to use a queue for storing data for FIFO accounting, and a
stack for LIFO accounting. We used a linked list for the implementation
of the stack and queue. We decided to test the system with just two
stocks, Google and Amazon. We built a simple command line interface
to test our program design.
