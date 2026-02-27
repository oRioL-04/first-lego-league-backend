package cat.udl.eps.softarch.fll.handler;

import java.time.ZonedDateTime;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;
import cat.udl.eps.softarch.fll.domain.Record;
import cat.udl.eps.softarch.fll.repository.RecordRepository;

@Component
@RepositoryEventHandler
public class RecordEventHandler {
	final RecordRepository recordRepository;

	public RecordEventHandler(RecordRepository recordRepository) {
		this.recordRepository = recordRepository;
	}

	@HandleBeforeCreate
	public void handleRecordPreCreate(Record userRecord) {
		ZonedDateTime timeStamp = ZonedDateTime.now();
		userRecord.setCreated(timeStamp);
		userRecord.setModified(timeStamp);
	}

	@HandleBeforeSave
	public void handleRecordPreSave(Record userRecord) {
		ZonedDateTime timeStamp = ZonedDateTime.now();
		userRecord.setModified(timeStamp);
	}
}
