export interface IParkingTicket {
    id: number;
    street: string;
    number: number;
    ticketType: string;
    arrivalTime: string;
    expiryTime: string;
    departureTime: string;
    status: string;
}