# SpeAR
Specification and Analysis for Requirements Tool

Spear is a tool for prototyping and analyzing requirements. It uses a simple specification language on the front-end to ease the system's engineers transition from writing natural language specification to formalizable specifications. The process is not automated; engineers will have to take natural language text and determine how to formalize them.

Once formalized, SpeAR will translate the specification to an equivalent Lustre model and analyze that the derived requirements permit (or prohibit) certain desired (or undesired) behaviors. It also supports the ability to check a specification for consistency, that is, that no derived requirements are in conflict.

Roadmap:
- User manual
- PDF Output to a more traditional requirements format
- Traceability of requirements to derived requirements by Inductive Validity Cores
- Type predicates to prevent tedious manual specification of type ranges, etc.
- User managed traceability much like DOORS
- Case study on using Spear to satisfy DO-178C Table A.3 and A.4 objectives
- Creation of an update site to ease installation and upgrading
- Development/implementation of Section Header profiles to make section header terminology more meaningful to different domains.
- Development of a design document
- Autogeneration of the frame condition
- Incorporation of real-time patterns
- Infrastructure/support to integrate better with the AGREE framework

Approved for Public Release. Distribution Unlimited. CASE NUMBER: 88ABW-2016-1658
