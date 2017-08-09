TARGET = largest_prime_factor
CC = gcc
CFLAGS = -Wall

.PHONY: clean

default: $(TARGET)

$(TARGET): $(TARGET).c
	$(CC) $(CFLAGS) -o $(TARGET) $(TARGET).c

debug: $(TARGET).c
	$(CC) $(CFLAGS) -g -o $(TARGET) $(TARGET).c

clean:
	-rm -f *.o
	-rm -f $(TARGET)
