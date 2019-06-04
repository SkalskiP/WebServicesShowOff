export class ResponseToObjectMapper {
    public static forHistoryRequest = (responseObject:any) => {
        return {
            id: responseObject.id ? responseObject.id : "",
            street: responseObject.parkingSpot ? responseObject.parkingSpot.street.name : "",
            number: responseObject.parkingSpot ? responseObject.parkingSpot.number : "",
            ticketType: responseObject.ticketType ? responseObject.ticketType.name : "",
            arrivalTime: responseObject.arrivalTime ? responseObject.arrivalTime : "",
            expiryTime: responseObject.expiryTime ? responseObject.expiryTime : "",
            departureTime: responseObject.departureTime ? responseObject.departureTime : "",
            status: responseObject.status ? responseObject.status : ""
        }
    }

    public static forDashboardRequest = (responseObject:any) => {
        return {
            id: responseObject.id ? responseObject.id : "",
            street: responseObject.street ? responseObject.street.name : "",
            number: responseObject ? responseObject.number : "",
            status: responseObject.occupied ? "OCCUPIED" : "EMPTY"
        }
    }
}