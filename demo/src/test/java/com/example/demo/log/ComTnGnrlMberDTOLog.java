package com.example.demo.log;

import com.example.demo.dto.ComTnGnrlMberDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ComTnGnrlMberDTOLog {

	public static void debug(ComTnGnrlMberDTO dto) {
		log.debug("dto: {}", dto);
		log.debug("getMberId: {}", dto.getMberId());
		log.debug("getPassword: {}", dto.getPassword());
		log.debug("getPasswordHint: {}", dto.getPasswordHint());
		log.debug("getPasswordCnsr: {}", dto.getPasswordCnsr());
		log.debug("getIhidnum: {}", dto.getIhidnum());
		log.debug("getMberNm: {}", dto.getMberNm());
		log.debug("getZip: {}", dto.getZip());
		log.debug("getAdres: {}", dto.getAdres());
		log.debug("getAreaNo: {}", dto.getAreaNo());
		log.debug("getMberSttus: {}", dto.getMberSttus());
		log.debug("getDetailAdres: {}", dto.getDetailAdres());
		log.debug("getEndTelno: {}", dto.getEndTelno());
		log.debug("getMbtlnum: {}", dto.getMbtlnum());
		log.debug("getGroupId: {}", dto.getGroupId());
		log.debug("getMberFxnum: {}", dto.getMberFxnum());
		log.debug("getMberEmailAdres: {}", dto.getMberEmailAdres());
		log.debug("getMiddleTelno: {}", dto.getMiddleTelno());
		log.debug("getSbscrbDe: {}", dto.getSbscrbDe());
		log.debug("getSexdstnCode: {}", dto.getSexdstnCode());
		log.debug("getEsntlId: {}", dto.getEsntlId());
		log.debug("getLockAt: {}", dto.getLockAt());
		log.debug("getLockCnt: {}", dto.getLockCnt());
		log.debug("getLockLastPnttm: {}", dto.getLockLastPnttm());
	}

}
